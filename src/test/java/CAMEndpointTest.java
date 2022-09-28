import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.StringWriter;

public class CAMEndpointTest {
    private static String BASE_URL = "https://api.b.dev.infinitycloud.io";
    @Test
    public void TestPrincipalDetails(){
        String GetPrincipalUrl = BASE_URL+"/config/v3/me";
        HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(GetCredentialsProvider()).build();
        HttpResponse httpResponse = null;
        StringWriter stringWriter = new StringWriter();
        try{
            httpResponse  = httpClient.execute(new HttpGet(GetPrincipalUrl));
            IOUtils.copy(httpResponse.getEntity().getContent(),stringWriter);
        }catch (Exception exp){
            System.out.println(exp.getMessage());
        }
        System.out.println(stringWriter.getBuffer().toString());
    }
    @Test
    public void TestGetAccess(){
        String GetPrincipalUrl = BASE_URL+"/config/v3/me/account";
        HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(GetCredentialsProvider()).build();
        HttpResponse httpResponse = null;
        StringWriter stringWriter = new StringWriter();
        try{
            httpResponse  = httpClient.execute(new HttpGet(GetPrincipalUrl));
            IOUtils.copy(httpResponse.getEntity().getContent(),stringWriter);
        }catch (Exception exp){
            System.out.println(exp.getMessage());
        }
        System.out.println(stringWriter.getBuffer().toString());
    }
    @Test
    public void TestGetAccountApplication(){
        String GetPrincipalUrl = BASE_URL+"/config/v3/me/account/vfutkj6g5w/application";
        HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(GetCredentialsProvider()).build();
        HttpResponse httpResponse = null;
        StringWriter stringWriter = new StringWriter();
        try{
            httpResponse  = httpClient.execute(new HttpGet(GetPrincipalUrl));
            IOUtils.copy(httpResponse.getEntity().getContent(),stringWriter);
        }catch (Exception exp){
            System.out.println(exp.getMessage());
        }
        System.out.println(stringWriter.getBuffer().toString());
    }
    private static CredentialsProvider GetCredentialsProvider(){
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        UsernamePasswordCredentials usernamePasswordCredentials = new UsernamePasswordCredentials(
                "B_rakesh.c.ranjan@oracle.com" ,"R@anjan@123"
        );
        credentialsProvider.setCredentials(AuthScope.ANY,usernamePasswordCredentials);
        return credentialsProvider;
    }
}
