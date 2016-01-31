package steps.data.api

import static groovyx.net.http.ContentType.*
/**
 * Created by jmcquaid on 11/01/16.
 */
class HttpRequestBuilder {
    static final String HTTP_POST = "post"
    static final String HTTP_GET = "get"

    def headers = [:]
    def method
    def query
    def body
    def url
    def requestContentType = TEXT

    public HttpRequestBuilder(url, method, headers, body=null, query = null){
        this.url = url
        this.method = method
        this.headers = headers
        this.body = body
        this.query = query
    }

    def getAttributeMap(){
        HashMap attributeMap = [:]
        attributeMap = [headers: this.headers, requestContentType: this.requestContentType]
        if(this.method == HTTP_POST)
            attributeMap.body = this.body
        if (query)
            attributeMap.query = this.query
        return attributeMap
    }
}
