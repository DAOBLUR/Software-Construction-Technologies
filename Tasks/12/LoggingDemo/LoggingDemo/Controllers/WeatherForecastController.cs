using Microsoft.AspNetCore.Mvc;

namespace LoggingDemo.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    
    public class WeatherForecastController : ControllerBase
    {
        private static readonly string[] Summaries = new[]
        {
            "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
        };

        private readonly ILogger<WeatherForecastController> _logger;

        public WeatherForecastController(ILogger<WeatherForecastController> logger)
        {
            _logger = logger;
        }

        [HttpGet]
        [Route("GetAllWeatherForecast")]
        public IEnumerable<WeatherForecast> GetAll()
        {
            return Enumerable.Range(1, 5).Select(index => new WeatherForecast
            {
                Date = DateOnly.FromDateTime(DateTime.Now.AddDays(index)),
                TemperatureC = Random.Shared.Next(-20, 55),
                Summary = Summaries[Random.Shared.Next(Summaries.Length)]
            })
            .ToArray();
        }

        [HttpGet]
        [Route("GetWeatherForecast")]
        public WeatherForecast GetAll(int index)
        {
            _logger.LogCritical("--LogCritical");
            _logger.LogError("--LogError");
            _logger.LogInformation("--LogInformation");
            _logger.LogWarning("--LogWarning");


            return Enumerable.Range(1, 5).Select(index => new WeatherForecast
            {
                Date = DateOnly.FromDateTime(DateTime.Now.AddDays(index)),
                TemperatureC = Random.Shared.Next(-20, 55),
                Summary = Summaries[Random.Shared.Next(Summaries.Length)]
            })
            .ToArray()[index];
        }

        [HttpGet]
        [Route("GetTemplevel")]
        public string Get(int index)
        {
            _logger.LogTrace($"--LogTrace - index: {index}");
            _logger.LogDebug($"--LogDebug index {index}");

            return Summaries[index];
        }

        [HttpGet]
        [Route("GetFirstTemplevel")]
        public string GetFirst()
        {
            _logger.Log(LogLevel.None, "--None");

            return Summaries[0];
        }
    }
}