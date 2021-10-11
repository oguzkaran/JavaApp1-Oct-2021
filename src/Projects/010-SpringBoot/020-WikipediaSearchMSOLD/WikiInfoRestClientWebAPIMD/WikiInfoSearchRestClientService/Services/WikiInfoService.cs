using CSD.Extensions.Net.Http;
using CSD.WikiInfoSearch.RestClientService.Models;
using System.Net.Http;
using System.Threading.Tasks;
using static System.Tuple;

namespace CSD.WikiInfoSearch.RestClientService.Services
{
    public class WikiInfoService : IWikiInfoService
    {
        private const string ms_baseURL = "http://192.168.1.167:45000/api/wikipedia/search";
        private readonly HttpClient m_httpClient;

        public WikiInfoService(HttpClient httpClient) => m_httpClient = httpClient;
       
        public async Task<WikiInfos> GetText(string queryText)
         => await m_httpClient.GetJsonSuccessAsync<WikiInfos>($"{ms_baseURL}", "Can not get wiki info", Create("q", queryText));
    }
}
