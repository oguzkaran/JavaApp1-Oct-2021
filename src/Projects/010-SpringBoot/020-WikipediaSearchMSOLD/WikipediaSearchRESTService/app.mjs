import {initRestService} from "./initRestService.mjs"

process.on("uncaughtException", err => console.log(err.message))

initRestService()
