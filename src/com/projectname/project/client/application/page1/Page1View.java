package com.projectname.project.client.application.page1;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class Page1View extends ViewImpl implements Page1Presenter.MyView {
    
	public interface Resources extends ClientBundle {

		@Source("test.jpg")
		ImageResource demoImage();
		
		@Source({ Css.DEFAULT_CSS })
		Css css();

	}

	public interface Css extends CssResource {

		String DEFAULT_CSS = "com/projectname/project/client/application/page1//Test.css";
		String mainPanel();
		String contentPanel();
		String panel1();
		String panel2();
		String panel3();
		String imagePreview();
	}

	@UiField(provided = true)
	Resources resources;
	
	@UiField
	HTMLPanel mainPanel;
	
	@UiField
	ImageElement image;
	
	interface Binder extends UiBinder<Widget, Page1View> {
    }

    @Inject
    Page1View(Binder uiBinder, Resources resources) {
    	this.resources = resources;
		resources.css().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
        image.setSrc(resources.demoImage().getSafeUri().asString());
    }
    
    
    @Override
    public int getMainPanelHeight() {
    
    	int height = mainPanel.getOffsetHeight();
    	
    	GWT.log("height before Timer and Scheduler: "+height);
    	
    	new Timer() {
			
			@Override
			public void run() {
				int height2 = mainPanel.getOffsetHeight();
		    	
		    	GWT.log("height after Timer: "+height2);
			}
		}.schedule(1000);
    	
		
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			
			@Override
			public void execute() {
					int height3 = mainPanel.getOffsetHeight();
		    	
		    	GWT.log("height after Scheduler: "+height3);
			}
		});
    	
    	return height;
    }
    
    
}
