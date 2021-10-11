/*
*{
    "summary": "Zonguldak Province is a province along the western Black Sea coast region of Turkey. The province is 3.481 km² in size and has a population of 619,703. Its adjacent provinces are Düzce to the southwest, Bolu to the south, Karabük to the southeast, and Bartın to the east. The capital is Zonguldak (...)",
    "elevation": 511,
    "lng": 31.733611111111113,
    "rank": 100,
    "thumbnailImg": "http://www.geonames.org/img/wikipedia/116000/thumb-115148-100.png",
    "lang": "en",
    "title": "Zonguldak Province",
    "lat": 41.32055555555556,
    "wikipediaUrl": "en.wikipedia.org/wiki/Zonguldak_Province"
    }
*
* */

class SearchObject {
    constructor(summary, elevation, lng, rank, thumbnailImg, lang, title, lat, wikipediaUrl)
    {
        this.summary = summary
        this.elevation = elevation
        this.lng = lng
        this.rank = rank
        this.thumbnailImg = thumbnailImg
        this.lang = lang
        this.title = title
        this.lat = lat
        this.wikipediaUrl = wikipediaUrl
    }
}

export {SearchObject}