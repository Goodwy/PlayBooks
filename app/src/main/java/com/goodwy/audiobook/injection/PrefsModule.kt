package com.goodwy.audiobook.injection

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import de.paulwoitaschek.flowpref.Pref
import de.paulwoitaschek.flowpref.android.AndroidPreferences
import de.paulwoitaschek.flowpref.android.boolean
import de.paulwoitaschek.flowpref.android.enum
import de.paulwoitaschek.flowpref.android.int
import de.paulwoitaschek.flowpref.android.stringSet
import com.goodwy.audiobook.BuildConfig
import com.goodwy.audiobook.common.pref.PrefKeys
import com.goodwy.audiobook.features.bookOverview.GridMode
import com.goodwy.audiobook.misc.UUIDAdapter
import java.util.UUID
import javax.inject.Named
import javax.inject.Singleton

@Module
object PrefsModule {

  @Provides
  @JvmStatic
  fun provideSharedPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences("${BuildConfig.APPLICATION_ID}_preferences", Context.MODE_PRIVATE)
  }

  @Provides
  @JvmStatic
  @Singleton
  fun prefs(sharedPreferences: SharedPreferences): AndroidPreferences {
    return AndroidPreferences(sharedPreferences)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.DARK_THEME)
  fun darkThemePref(prefs: AndroidPreferences): Pref<Boolean> {
    return prefs.boolean(PrefKeys.DARK_THEME, false)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.CONTENTS_BUTTON_MODE)
  fun tintNavBar(prefs: AndroidPreferences): Pref<Boolean> {
    return prefs.boolean(PrefKeys.CONTENTS_BUTTON_MODE, false)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.SHOW_RATING)
  fun showRatingPref(prefs: AndroidPreferences): Pref<Boolean> {
    return prefs.boolean(PrefKeys.SHOW_RATING, true)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.SHOW_SLIDER_VOLUME)
  fun showSliderVolumePref(prefs: AndroidPreferences): Pref<Boolean> {
    return prefs.boolean(PrefKeys.SHOW_SLIDER_VOLUME, false)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.DEV_MODE)
  fun devModePref(prefs: AndroidPreferences): Pref<Boolean> {
    return prefs.boolean(PrefKeys.DEV_MODE, false)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.ICON_MODE)
  fun iconModePref(prefs: AndroidPreferences): Pref<Boolean> {
    return prefs.boolean(PrefKeys.ICON_MODE, false)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.SCREEN_ORIENTATION)
  fun screenOrientationPref(prefs: AndroidPreferences): Pref<Boolean> {
    return prefs.boolean(PrefKeys.SCREEN_ORIENTATION, false)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.SHOW_MINI_PLAYER)
  fun showMiniPlayerPref(prefs: AndroidPreferences): Pref<Boolean> {
    return prefs.boolean(PrefKeys.SHOW_MINI_PLAYER, false)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.MINI_PLAYER_STYLE)
  fun miniPlayerStylePref(prefs: AndroidPreferences): Pref<Int> {
    return prefs.int(PrefKeys.MINI_PLAYER_STYLE, 1)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.REWIND_BUTTON_STYLE)
  fun rewindButtonStylePref(prefs: AndroidPreferences): Pref<Int> {
    return prefs.int(PrefKeys.REWIND_BUTTON_STYLE, 1)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.RESUME_ON_REPLUG)
  fun provideResumeOnReplugPreference(prefs: AndroidPreferences): Pref<Boolean> {
    return prefs.boolean(PrefKeys.RESUME_ON_REPLUG, true)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.AUTO_REWIND_AMOUNT)
  fun provideAutoRewindAmountPreference(prefs: AndroidPreferences): Pref<Int> {
    return prefs.int(PrefKeys.AUTO_REWIND_AMOUNT, 2)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.SEEK_TIME)
  fun provideSeekTimePreference(prefs: AndroidPreferences): Pref<Int> {
    return prefs.int(PrefKeys.SEEK_TIME, 20)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.SEEK_TIME_REWIND)
  fun provideSeekTimeRewindPreference(prefs: AndroidPreferences): Pref<Int> {
    return prefs.int(PrefKeys.SEEK_TIME_REWIND, 20)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.SLEEP_TIME)
  fun provideSleepTimePreference(prefs: AndroidPreferences): Pref<Int> {
    return prefs.int(PrefKeys.SLEEP_TIME, 20)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.SINGLE_BOOK_FOLDERS)
  fun provideSingleBookFoldersPreference(prefs: AndroidPreferences): Pref<Set<String>> {
    return prefs.stringSet(PrefKeys.SINGLE_BOOK_FOLDERS, emptySet())
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.COLLECTION_BOOK_FOLDERS)
  fun provideCollectionFoldersPreference(prefs: AndroidPreferences): Pref<Set<String>> {
    return prefs.stringSet(PrefKeys.COLLECTION_BOOK_FOLDERS, emptySet())
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.CURRENT_BOOK)
  fun provideCurrentBookIdPreference(prefs: AndroidPreferences): Pref<UUID> {
    return prefs.create(PrefKeys.CURRENT_BOOK, UUID.randomUUID(), UUIDAdapter)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.GRID_MODE)
  fun gridViewPref(prefs: AndroidPreferences): Pref<GridMode> {
    return prefs.enum(PrefKeys.GRID_MODE, GridMode.FOLLOW_DEVICE)
  }

  @Provides
  @JvmStatic
  @Singleton
  @Named(PrefKeys.GRID_AUTO)
  fun gridViewAutoPref(prefs: AndroidPreferences): Pref<Boolean> {
    return prefs.boolean(PrefKeys.GRID_AUTO, true)
  }
}
