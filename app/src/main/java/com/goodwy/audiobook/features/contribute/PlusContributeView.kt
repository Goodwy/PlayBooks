package com.goodwy.audiobook.features.contribute

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.use
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import com.goodwy.audiobook.R
import com.goodwy.audiobook.databinding.MergeContributeRowPlusBinding
import com.goodwy.audiobook.misc.dpToPxRounded
import com.goodwy.audiobook.misc.layoutInflater
import com.goodwy.audiobook.uitools.drawableFromAttr

class PlusContributeView : ConstraintLayout {

  private val binding = MergeContributeRowPlusBinding.inflate(layoutInflater(), this)

  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    context.theme.obtainStyledAttributes(attrs, R.styleable.DarkContributeView, 0, 0).use {
      binding.contributePlusTitle.text = it.getText(R.styleable.DarkContributeView_dcv_title)
      binding.contributePlusDescription.text = it.getText(R.styleable.DarkContributeView_dcv_description)
      binding.contributePlusDescription.isVisible = binding.contributePlusDescription.text?.isNotBlank() == true
    }
  }

  init {
    foreground = context.drawableFromAttr(R.attr.selectableItemBackground)
    val padding = context.dpToPxRounded(8F)
    updatePadding(top = padding, bottom = padding)
  }

  fun onCheckedChanged(listener: () -> Unit) {
    setOnClickListener { listener() }
  }
}
