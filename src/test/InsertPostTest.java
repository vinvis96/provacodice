package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.bean.PostBean;
import logic.control.ControlRequestPost;
import logic.control.ControlSamplePost;
import logic.control.ControlTopicPost;

class InsertPostTest {

	@Test
	public void insertSamplePostTest() {

		ControlSamplePost ctrlSamplePost = new ControlSamplePost();
		
		PostBean postBean = new PostBean();
		
		postBean.setTitolo("Titolo sample");
		postBean.setAutore("gino");
		postBean.setDescrizione("descrizione Sample");
		postBean.setNomeSample("Nome del sample");
		
		int output = ctrlSamplePost.insertSamplePost(postBean);
		
		assertEquals(1, output); //giustamente da' errore perch� il sample va inserito dal bottone upload nella GUI
	}
	
	@Test
	public void insertTopicPostTest() {
		
		ControlTopicPost ctrlTopicPost = new ControlTopicPost();
		
		PostBean postBean = new PostBean(); 
		
		postBean.setTitolo("nuovo titolo");
		postBean.setAutore("gino");
		postBean.setDescrizione("Descrizione post");
		postBean.setArgomento("Argomento post");
		
		int output = ctrlTopicPost.insertTopicPost(postBean);
		
		assertEquals(1,output);
	}
	
	@Test
	public void insertRequestPostTest() {
		
		ControlRequestPost ctrlRequestPost = new ControlRequestPost();
		
		PostBean postBean = new PostBean();
		
		postBean.setTitolo("request titolo");
		postBean.setAutore("gino");
		postBean.setDescrizione("Descrizione request");
		
		int output = ctrlRequestPost.insertRequestPost(postBean);
		
		assertEquals(1, output);
	}

}
