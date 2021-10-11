import {sendJSONSuccess} from "../..//modules/org-csystem-restutil.mjs"
import express from "express"
import {findWikiByText} from "./repository.mjs";
import {SearchInfo} from "./SearchInfo.mjs";

const app = express()
const serverPort = 50500

function areDefined()
{
    for (let arg of arguments)
        if (arg === undefined)
            return false
    return true
}

function searchByText(req, res)
{
    let text = req.query.text

    findWikiByText(text, jsonData => sendJSONSuccess(res, jsonData), err => sendJSONSuccess(res, new SearchInfo()))
}

export function initRestService()
{
    console.log(`wiki search service is listening on port:${serverPort}`)
    app.get("/api/wikisearch", (req, res) => searchByText(req, res))
    app.use((req, res) => sendJSON404(res, pageNotFoundHtml))
    app.listen(serverPort)
}