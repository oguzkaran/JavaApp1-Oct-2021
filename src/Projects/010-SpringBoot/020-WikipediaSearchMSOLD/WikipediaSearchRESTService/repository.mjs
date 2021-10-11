import {getMongoClient} from "../../modules/org-csystem-mongoutil.mjs"
import nodeRestClient from "node-rest-client"

const host = "localhost"
const port = 27017
const dbName = "wikisearchdb"
const collectionName = "searchobjects"

const geonamesUrl = "http://api.geonames.org/wikipediaSearchJSON?formatted=true&maxRows=10&username=csystem&style=full&q="
const Client = nodeRestClient.Client

function doWorkForkData(mongoClient, searchText, successCallback, failCallback)
{
    let objects = mongoClient.db(dbName).collection(collectionName)
    let searchObjects = {q : searchText}

    objects.find(searchObjects).toArray((err, docs) => {
        if (err) {
            failCallback(err)
            return
        }

        if (!docs.length) {
            let restClient = new Client();

            restClient.get(`${geonamesUrl}${searchText}`, (data, response) => {
                successCallback(data)
            })
            //veritabanına ekle
        } else {
            //veritabaından al ve yayınla
        }
    })
}

function findWikiByText(searchText, successCallback, failCallback)
{
    getMongoClient(host, port).connect((err, mongoClient) => {
        if (err)
            throw err

        doWorkForkData(mongoClient, searchText, successCallback, failCallback)
    })
}

export {findWikiByText}