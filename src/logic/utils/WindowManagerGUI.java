package logic.utils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.boundary.LoginGUI;
import logic.boundary.MemberBandRequestGUI;
import logic.boundary.ProfileGUI;
import logic.boundary.RecoverDataGUI;
import logic.boundary.RegisterGUI;
import logic.boundary.SamplePostGUI;
import logic.boundary.SendMessagesGUI;
import logic.boundary.TopicGUI;
import logic.interfaces.IUser;

public class WindowManagerGUI extends Application {
	
	private static WindowManagerGUI instance = null;
	
	private IUser user = null;

	private Scene LoginPage;
	private Scene RegisterPage;
	private Scene RecoverDataPage;
	private Scene HomePage;
	private Scene MessagesPage;
	private Scene ProfilePage;
	private Scene SamplePostPage;
	private Scene MemberBandPage;
	private Scene TopicPage;
	private Scene RankingPage;
	private Scene DoAReportPage;
	private Scene ViewRulesPage;
	private Scene InsertSamplePostPage;
	private Scene FindPostPage;
	private Scene ManageSamplePostPage;
	private Scene ModifyProfilePage;
	private Scene ModifyDataPage;
	private Scene InsertRequestPostPage;
	private Scene ManageRequestPostPage;
	
	private static Stage myStage;

	public static void main(String[] args) {
		
		launch(args);
	}

	public void start(Stage myStage) {
		WindowManagerGUI.myStage = myStage;
		myStage.setTitle("Program Window");
		
		loadLoginPage();
		myStage.show();
		
	}
	
	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}
	
	public static WindowManagerGUI getWindowManagerGUIInstance() {
		if (WindowManagerGUI.instance == null)
			WindowManagerGUI.instance = new WindowManagerGUI();
		return instance;
	}

	public void loadLoginPage() {
		VBox Login = LoginGUI.getLoginPageScene();
		LoginPage = new Scene(Login, 500, 500);
		WindowManagerGUI.myStage.setScene(LoginPage);
	}

	public void loadRegisterPage() {
		VBox Register = RegisterGUI.getRegisterPageScene();
		RegisterPage = new Scene(Register, 500, 500);
		WindowManagerGUI.myStage.setScene(RegisterPage);
	}

	public void loadRecoverDataPage() {
		VBox RecoverData = RecoverDataGUI.getRecoverDataPageScene();
		RecoverDataPage = new Scene(RecoverData, 500, 500);
		WindowManagerGUI.myStage.setScene(RecoverDataPage);
	}

	public void loadHomePage() {
		VBox Home = HomepageGUI.getHomepageScene();
		HomePage = new Scene(Home, 500, 500);
		WindowManagerGUI.myStage.setScene(HomePage);
	}

	public void loadMessagesPage() {
		VBox Messages = SendMessagesGUI.getMessagesScene();
		MessagesPage = new Scene(Messages, 500, 500);
		WindowManagerGUI.myStage.setScene(MessagesPage);
	}

	public void loadProfilePage() {
		VBox Profile = ProfileGUI.getProfileScene();
		ProfilePage = new Scene(Profile,500,500); 
		WindowManagerGUI.myStage.setScene(ProfilePage);
	}

	public void loadSamplePostPage() {
		VBox SamplePost = SamplePostGUI.getSamplePostScene();
		SamplePostPage = new Scene(SamplePost, 500, 500);
		WindowManagerGUI.myStage.setScene(SamplePostPage);
	}

	public void loadMemberBandPage() {
		VBox MemberBand = MemberBandRequestGUI.getMemberBandScene();
		MemberBandPage = new Scene(MemberBand,500,500); 
		WindowManagerGUI.myStage.setScene(MemberBandPage);
	}

	public void loadTopicPage() {
		VBox Topic = TopicGUI.getTopicScene();
		TopicPage = new Scene(Topic, 500, 500);
		WindowManagerGUI.myStage.setScene(TopicPage);
	}

	public void loadRankingPage() {
		VBox Ranking = RankingGUI.getRankingScene();
		RankingPage = new Scene(Ranking, 500, 500);
		WindowManagerGUI.myStage.setScene(RankingPage);
	}

	public void loadDoAReportPage() {
		// VBox DoAReport = DoAReportGUI.getDoAReportScene();
		// DoAReportPage = new Scene(DoAReport,500,500);
		WindowManagerGUI.myStage.setScene(DoAReportPage);
	}

	public void loadViewRulesPage() {
		VBox ViewRules = ViewRulesGUI.getViewRulesScene();
		ViewRulesPage = new Scene(ViewRules, 500, 500);
		WindowManagerGUI.myStage.setScene(ViewRulesPage);
	}
	
	public void loadFindPostPage(int i) {
		VBox FindPost = FindPostGUI.getFindPostScene(i);
		FindPostPage = new Scene(FindPost, 500, 500);
		WindowManagerGUI.myStage.setScene(FindPostPage);

	}

	public void loadInsertSamplePostPage() {
		VBox InsertSamplePost = InsertSamplePostGUI.getInsertSamplePostScene();
		InsertSamplePostPage = new Scene(InsertSamplePost, 500, 500);
		WindowManagerGUI.myStage.setScene(InsertSamplePostPage);

	}
	
	public void loadManageSamplePostPage() {
		VBox ManagePost = ManageSamplePostGUI.getManageSamplePostScene();
		ManageSamplePostPage = new Scene(ManagePost, 500, 500);
		WindowManagerGUI.myStage.setScene(ManageSamplePostPage);		
	} 
	
	public void loadModifyProfilePage() {
		VBox ModifyProfile = ModifyProfileGUI.getModifyProfileScene();
		ModifyProfilePage = new Scene(ModifyProfile, 500, 500);
		WindowManagerGUI.myStage.setScene(ModifyProfilePage);	
	}
	
	public void loadModifyDataPage() {
		VBox ModifyData = ModifyDataGUI.getModifyDataScene();
		ModifyDataPage = new Scene(ModifyData, 500, 500);
		WindowManagerGUI.myStage.setScene(ModifyDataPage);		
	}

	public void loadInsertRequestPostPage() {
		VBox InsertRequestPost = InsertRequestPostGUI.getInsertRequestPostScene();
		InsertRequestPostPage = new Scene(InsertRequestPost, 500, 500);
		WindowManagerGUI.myStage.setScene(InsertRequestPostPage);		
	}

	public void loadManageRequestPostPage() {
		VBox ManageRequestPost = ManageRequestPostGUI.getManageRequestPostScene();
		ManageRequestPostPage = new Scene(ManageRequestPost, 500, 500);
		WindowManagerGUI.myStage.setScene(ManageRequestPostPage);	
	}

}