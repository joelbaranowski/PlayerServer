/*
 * Copyright (c) 2011 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package request;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;

/**
 * 
 * 
 * @author Joel Baranowski
 * @author Yaniv Inbar //developed Dailymotion example this is based on.
 */
public class MakePost {

  private HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
  private JsonFactory JSON_FACTORY = new JacksonFactory();
  private ServletUrl url;

  HttpRequestFactory requestFactory = HTTP_TRANSPORT
      .createRequestFactory(new HttpRequestInitializer() {
        @Override
        public void initialize(HttpRequest request) {
          request.setParser(new JsonObjectParser(JSON_FACTORY));
        }
      });

  public static class ServletUrl extends GenericUrl {

    public ServletUrl(String encodedUrl) {
      super(encodedUrl);
    }

    @Key
    public String fields;
  }

  public MakePost(String inUrl) {
    url = new ServletUrl(inUrl);
  }

  public String execute() throws Exception {
    HttpContent hc = new JsonHttpContent(JSON_FACTORY, "test");
   requestFactory.buildPostRequest(url, hc).executeAsync();
   return "test";
  }
}
