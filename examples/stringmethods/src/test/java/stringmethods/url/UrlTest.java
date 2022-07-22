package stringmethods.url;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlTest {

    Url url;

    @Test
    void testSimpleUrl() {
        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        this.url = new Url(url);

        assertEquals("https", this.url.getProtocol());
        assertEquals("earthquake.usgs.gov", this.url.getHost());
        assertEquals("/fdsnws/event/1/query", this.url.getPath());
        assertNull(this.url.getPort());
    }

    @Test
    void testUrlWithPortAtEnd() {
        String urlWithPortAtEnd = "HTTPS://EarthQuake.USgs.gov:80";
        url = new Url(urlWithPortAtEnd);

        assertEquals("https", url.getProtocol());
        assertEquals("earthquake.usgs.gov", url.getHost());
        assertEquals("", url.getPath());
        assertEquals(80, url.getPort());
    }

    @Test
    void testUrlWithPort() {
        String urlWithPort = "HTTPS://EarthQuake.USgs.gov:80/query?a=4";
        url = new Url(urlWithPort);

        assertEquals("https", url.getProtocol());
        assertEquals("earthquake.usgs.gov", url.getHost());
        assertEquals("/query", url.getPath());
        assertEquals(80, url.getPort());
    }

    @Test
    void testUrlWithProperty() {
        String urlWithProperty = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        url = new Url(urlWithProperty);

        assertEquals(true, url.hasProperty("format"));
        assertEquals("geojson", url.getProperty("format"));
        assertEquals(false, url.hasProperty("place"));
        assertNull(url.getProperty("place"));
        assertEquals(false, url.hasProperty("time"));
        assertNull(url.getProperty("time"));
    }
}