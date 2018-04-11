package services

import java.util.Calendar

import javax.inject.Inject

class RealGreetingService @Inject()(calendar: Calendar)extends GreetingService {
  def greeting: String = {
    val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
    if (currentHour < 12)
      "Good morning!"
    else
      "Good afternoon!"
  }
}

trait GreetingService {
  def greeting: String
}
