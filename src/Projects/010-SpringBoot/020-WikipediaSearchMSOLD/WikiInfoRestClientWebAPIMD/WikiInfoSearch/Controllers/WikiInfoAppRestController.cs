using CSD.WikiInfoSearch.RestClientService.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Threading.Tasks;

namespace CSD.WikiInfoSearch.Controllers
{
    [Route("api/wikisearch")]
    [ApiController]
    public class WikiInfoAppRestController : ControllerBase
    {
        private readonly IWikiInfoService m_wikiInfoService;

        public WikiInfoAppRestController(IWikiInfoService wikiInfoService)  => m_wikiInfoService = wikiInfoService;

        [HttpGet]
        public async Task<IActionResult> GetWiki(string text)
        {
            try
            {
                var wikiInfos = await m_wikiInfoService.GetText(text);
                return new ObjectResult(wikiInfos);
            }
            catch (Exception ex)
            {
                return BadRequest(ex);
            }
        }
    }
}
