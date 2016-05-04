package services

import javax.inject.Inject

import akka.actor.Actor
import com.google.inject.Injector

class ParentActor @Inject()(val injector: Injector, factory: ChildFactory) {

}

trait ChildFactory {
  def apply: Actor
}