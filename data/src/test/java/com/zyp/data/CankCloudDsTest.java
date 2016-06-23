package com.zyp.data;

import com.example.common.Constants;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.zyp.data.service.GankInfoService;
import com.zyp.data.service.ServiceManager;
import com.zyp.domain.model.CategoryDataResult;
import com.zyp.domain.model.EveryDayDataResult;
import com.zyp.domain.model.RandomDataResult;
import com.zyp.domain.model.SearchDataResult;
import com.zyp.domain.model.SpecificDateDataResult;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.TimeUnit;

import rx.observers.TestSubscriber;

import static org.mockito.BDDMockito.given;

/**
 * Created by zyp on 2016/6/22.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21, application = ApplicationStub.class)
public class CankCloudDsTest {
    GankCloudDs gankCloudDs;

    @Mock
    ServiceManager mockServiceManager;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        given(mockServiceManager.getGankInfoService()).willReturn(createGankInfoService());
        gankCloudDs = new GankCloudDs(mockServiceManager);
    }

    @Test
    public void testGetCategoryData(){
        TestSubscriber<CategoryDataResult> testSubscriber = new TestSubscriber<>();
        gankCloudDs.getCategoryData("Android",20,1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        System.out.println(testSubscriber.getOnNextEvents().get(0));
    }

    @Test
    public void testGetEveryDayData(){
        TestSubscriber<EveryDayDataResult> testSubscriber = new TestSubscriber<>();
        gankCloudDs.getEveryDayData().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        System.out.println(testSubscriber.getOnNextEvents().get(0));
    }

    @Test
    public void testGetRandomData(){
        TestSubscriber<RandomDataResult> testSubscriber = new TestSubscriber<>();
        gankCloudDs.getRandomData("Android",10).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        System.out.println(testSubscriber.getOnNextEvents().get(0));
    }

    @Test
    public void testGetSpecificDateData(){
        TestSubscriber<SpecificDateDataResult> testSubscriber = new TestSubscriber<>();
        gankCloudDs.getSpecificDateData(2016,05,11).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        System.out.println(testSubscriber.getOnNextEvents().get(0));
    }

    @Test
    public void testGetSearchData(){
        TestSubscriber<SearchDataResult> testSubscriber = new TestSubscriber<>();
        gankCloudDs.getSearchData("listview","Android",10,1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        System.out.println(testSubscriber.getOnNextEvents().get(0));
    }

    public GankInfoService createGankInfoService() {

        return ServiceManager.createRestService(Constants.EndPoint.END_POINT_GANK_IO_SERVICE,
                createRestClient(), GankInfoService.class);
    }

    public  OkHttpClient createRestClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                System.out.println(message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient restClient = new OkHttpClient();
        restClient.interceptors().add(logging);
        restClient.setConnectTimeout(Constants.Http.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        restClient.setReadTimeout(Constants.Http.READ_TIMEOUT, TimeUnit.MILLISECONDS);

        return restClient;
    }


}
