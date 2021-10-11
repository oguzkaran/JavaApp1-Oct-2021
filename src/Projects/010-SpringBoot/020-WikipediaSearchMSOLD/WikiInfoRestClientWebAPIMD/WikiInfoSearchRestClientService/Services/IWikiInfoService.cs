using CSD.WikiInfoSearch.RestClientService.Models;
using System.Threading.Tasks;

namespace CSD.WikiInfoSearch.RestClientService.Services
{
    public interface IWikiInfoService 
    {
        Task<WikiInfos> GetText(string queryText);
    }
}