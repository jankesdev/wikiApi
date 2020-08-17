# WikiApi

The app uses the wikipedia api. The application get a short description of the football club and a link to the wikipedia source based on the club name.

#### Installation

```bash
git clone https://github.com/jankesdev/wikiApi
```

#### Run the application - mvn

1. `cd wikiApi`
2. `mvn install`
3. `mvn spring-boot:run`

#### Run in Docker

1. Build project
`cd wikiApi`
2. `docker build -t wikiapi/wikiapi .`
2. `docker run -p 8080:8080 wikiapi/wikiapi`

#### Documentation API - swagger

```bash
http://localhost:8080/swagger-ui.html
```

#### Get club
Example
```bash
http://localhost:8080/api/club?name=Liverpool
```

Response

```bash
{
    "name": "Liverpool F.C.",
    "url": "https://en.wikipedia.org/wiki/Liverpool_F.C.",
    "snippet": "<span class=\"searchmatch\">Liverpool</span> Football Club is a professional football club in <span class=\"searchmatch\">Liverpool</span>, England, that competes in the Premier League, the top tier of English football. Domestically"
}
```