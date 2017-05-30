package controllers

import javax.inject.Inject

import play.api.Configuration
import play.api.libs.ws.WSClient
import play.api.mvc.{Action, Controller}

class Application @Inject()(configuration: Configuration, ws: WSClient) extends Controller {
    def index = Action {
        Ok
    }
}
