package services

trait SquarerTyped {
  def squareNow(i: Int): Int //blocking send-request-reply
}

class SquarerTypedImpl extends SquarerTyped {
  def squareNow(i: Int): Int = i * i
}


