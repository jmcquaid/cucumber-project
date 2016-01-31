package steps.data.api

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovyx.net.http.HttpResponseDecorator
import org.apache.http.Header

/**
 * Created by jmcquaid on 10/06/15.
 *
 * This is a wrapper for the response that is returned by class groovyx.net.http.RESTClient.
 * The RESTClient class automatically parses the  http response body, which is not always convenient for test purposes.
 * This wrapper class returns the string form of the response body.
 */
class HttpResponseWrapper {

    private HttpResponseDecorator response
    def status
    def body
    Header[] headers

    def HttpResponseWrapper(HttpResponseDecorator response) {
        this.response = response
        this.status = response.status
        this.headers = response.getAllHeaders()
        if(findHeaderValue("Content-Type")?.contains("json")){
            this.body = JsonOutput.toJson(response.getData())
        }
        else{
            this.body = response.getData()?.text
        }
    }

    static def extractIdFromLocationUrl(urlStr) {
        return urlStr.substring(urlStr.lastIndexOf('/') + 1, urlStr.size())
    }

    def findHeaderValue(headerName) {
        def headerValue = null

        def header = headers.find() { header ->
            header.getName() == headerName
        }

        if(header){
            headerValue = header.getValue()
        }
        headerValue
    }

    def getBodyAsJson() {
        new JsonSlurper().parseText(body)
    }

    // FIXME This feels wrong, we shouldn't be testing against a "null" literal!!! It looks like that is something to do with the library.
    boolean isBodyNull() {
        body == "null" || body == null
    }

    def findLocationHeader() {
        findHeaderValue(OrcaServiceAdapter.LOCATION)
    }

    @Override
    public String toString() {
        return "HttpResponseWrapper{" +
                "response=" + response +
                ", status=" + status +
                ", body=" + body +
                ", headers=" + Arrays.toString(headers) +
                '}';
    }
}