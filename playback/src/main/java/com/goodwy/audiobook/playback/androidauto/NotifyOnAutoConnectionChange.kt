package com.goodwy.audiobook.playback.androidauto

import de.paulwoitaschek.flowpref.Pref
import com.goodwy.audiobook.common.pref.PrefKeys
import com.goodwy.audiobook.data.repo.BookRepository
import com.goodwy.audiobook.playback.di.PerService
import com.goodwy.audiobook.playback.session.ChangeNotifier
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import java.util.UUID
import javax.inject.Inject
import javax.inject.Named

/**
 * Notifies about changes upon android auto connection.
 */
@PerService
class NotifyOnAutoConnectionChange
@Inject constructor(
  private val changeNotifier: ChangeNotifier,
  private val repo: BookRepository,
  @Named(PrefKeys.CURRENT_BOOK)
  private val currentBookIdPref: Pref<UUID>,
  private val autoConnection: AndroidAutoConnectedReceiver
) {

  suspend fun listen() {
    autoConnection.stream
      .filter { it }
      .collect {
        // display the current book but don't play it
        val book = repo.bookById(currentBookIdPref.value)
        if (book != null) {
          changeNotifier.updateMetadata(book)
        }
      }
  }
}
