package com.goodwy.audiobook.features.about

sealed class AboutViewEffect {

  data class ShowChangeSkipAmountDialog(val amountInSeconds: Int) : AboutViewEffect()
  data class ShowChangeAutoRewindAmountDialog(val amountInSeconds: Int) : AboutViewEffect()
}
