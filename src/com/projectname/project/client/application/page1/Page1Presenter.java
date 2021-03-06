package com.projectname.project.client.application.page1;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.projectname.project.client.application.ApplicationPresenter;
import com.projectname.project.client.place.NameTokens;
import com.projectname.project.client.rest.SomeService;

public class Page1Presenter extends Presenter<Page1Presenter.MyView, Page1Presenter.MyProxy> {
    interface MyView extends View {
    	int getMainPanelHeight();
    }

    @ProxyStandard
    @NameToken(NameTokens.PAGE1)
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<Page1Presenter> {
    }

    private final PlaceManager placeManager;
    private final RestDispatchAsync dispatcher;
    private final SomeService someService;

    @Inject
    Page1Presenter(EventBus eventBus,
                   MyView view,
                   MyProxy proxy,
                   PlaceManager placeManager,
                   RestDispatchAsync dispatcher,
                   SomeService someService) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN_CONTENT);

        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        this.someService = someService;
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        
        GWT.log("onReveal");

        int height = getView().getMainPanelHeight();
        
      
    }
}
