package com.goodwy.audiobook.features.bookOverview.list

import com.goodwy.audiobook.data.Book
import com.goodwy.audiobook.features.bookOverview.list.header.BookOverviewHeaderComponent
import com.goodwy.audiobook.features.bookOverview.list.header.OpenCategoryListener
import com.goodwy.audiobook.misc.recyclerComponent.CompositeListAdapter
import java.util.UUID

typealias BookClickListener = (Book, BookOverviewClick) -> Unit

class BookOverviewAdapter(
  bookClickListener: BookClickListener,
  openCategoryListener: OpenCategoryListener
) : CompositeListAdapter<BookOverviewItem>(BookOverviewDiff()) {

  init {
    addComponent(GridBookOverviewComponent(bookClickListener))
    addComponent(ListBookOverviewComponent(bookClickListener))
    addComponent(BookOverviewHeaderComponent(openCategoryListener))
  }

  fun reloadBookCover(bookId: UUID) {
    for (i in 0 until itemCount) {
      val item = getItem(i)
      if (item is BookOverviewModel && item.book.id == bookId) {
        notifyItemChanged(i)
        break
      }
    }
  }

  fun itemAtPositionIsHeader(position: Int): Boolean {
    val item = getItem(position)
    return item is BookOverviewHeaderModel
  }
}
