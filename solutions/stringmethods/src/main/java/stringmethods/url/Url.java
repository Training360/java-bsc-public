package stringmethods.url;

public class Url {

    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;

    public Url(String url) {
        findProtocolInUrl(url);
        findPortInUrl(url);
        findHostInUrl(url);
        findPathInUrl(url);
        findQueryInUrl(url);
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public String getQuery() {
        return query;
    }

    public boolean hasProperty(String key) {
        return query.startsWith(key + "=") || query.contains("&" + key + "=");
    }

    public String getProperty(String key) {
        String[] properties = query.split("&");
        for (String str : properties) {
            String[] prop = str.split("=");
            if (prop[0].equals(key)) {
                return prop[1];
            }
        }
        return null;
    }

    private void findProtocolInUrl(String url) {
        int endIndex = url.indexOf("://");
        protocol = url.substring(0, endIndex).toLowerCase();
    }

    private void findPortInUrl(String url) {
        int startIndex = url.indexOf("://") + 3;
        startIndex = url.indexOf(":", startIndex);
        if (startIndex == -1) {
            port = null;
            return;
        }
        int endIndex = url.indexOf("/", startIndex);
        if (endIndex == -1) {
            port = Integer.valueOf(url.substring(startIndex + 1));
        } else {
            port = Integer.valueOf(url.substring(startIndex + 1, endIndex));
        }
    }

    private void findHostInUrl(String url) {
        int startIndex = url.indexOf("://") + 3;
        int endIndex = url.indexOf(":", startIndex);
        if (endIndex == -1) {
            endIndex = url.indexOf("/", startIndex);
        }
        if (endIndex == -1) {
            host = url.substring(startIndex).toLowerCase();
        } else {
            host = url.substring(startIndex, endIndex).toLowerCase();
        }
    }

    private void findPathInUrl(String url) {
        int startIndex = url.indexOf("://") + 3;
        startIndex = url.indexOf("/", startIndex);
        if (startIndex == -1) {
            path = "";
            return;
        }
        int endIndex = url.indexOf("?");
        if (endIndex == -1) {
            path = url.substring(startIndex);
        } else {
            path = url.substring(startIndex, endIndex);
        }
    }

    private void findQueryInUrl(String url) {
        int startIndex = url.indexOf("?");
        if (startIndex == -1) {
            query = "";
        } else {
            query = url.substring(startIndex + 1);
        }
    }
}
