package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.bean.PostBean;
import logic.dao.PostDAO;
import logic.entity.Post;
import logic.utils.WindowManagerGUI;

public class ControlTopicPost {

	public List<PostBean> getTopicPosts() {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<PostBean>();
		
		
		for (i = 0; i < post.size(); i++) {
			
			if(post.get(i).getNomeSample().equals("null") && !post.get(i).getArgomento().equals("null")) {
				
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getId());
				postBean.setTitolo(post.get(i).getTitolo());
				postBean.setAutore(post.get(i).getAutore());
				postBean.setDescrizione(post.get(i).getDescrizione());
				postBean.setArgomento(post.get(i).getArgomento());
					
				postBeanList.add(postBean);
				
			}
				
		}
		
		return postBeanList;
	}

	public List<PostBean> filterTopicPostByUsername(String username) {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<PostBean>();
		
		
		for (i = 0; i < post.size(); i++) {
						
			if(post.get(i).getAutore().equals(username) && !post.get(i).getArgomento().equals("null")) {
								
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getId());
				postBean.setTitolo(post.get(i).getTitolo());
				postBean.setAutore(post.get(i).getAutore());
				postBean.setDescrizione(post.get(i).getDescrizione());
				postBean.setArgomento(post.get(i).getArgomento());
				
				postBeanList.add(postBean);
				
			}
		}
		
		return postBeanList;
	}

	public int insertTopicPost(PostBean postBean) {
				
		if(postBean.getArgomento().length()==0 || postBean.getTitolo().length()==0 || postBean.getDescrizione().length()==0){
			
			return -1;
			
		} else {
			
			Post post = new Post();
			
			post.setAutore(postBean.getAutore());
			post.setTitolo(postBean.getTitolo());
			post.setDescrizione(postBean.getDescrizione());
			post.setArgomento(postBean.getArgomento());
					
			PostDAO.insertPost(post);
			
			return 1;
		}	
		
	}

	public int removeTopicPost(int num) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		List<PostBean> post = filterTopicPostByUsername(win.getUser().getUsername());
		
		if(num>=0 && num<post.size()) {
						
			PostDAO.deletePost(post.get(num).getId());
			return 1;
			
		} else {
			
			return -1;
		}
		
	}

	public int checkId(int pos) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		List<PostBean> post = filterTopicPostByUsername(win.getUser().getUsername());
		
		if(pos<0 || pos>post.size() ) {
			
			return -1;
		}
		
		return pos;
	}

	public int modifyTopicPost(PostBean postBean, int pos) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		List<PostBean> post = filterTopicPostByUsername(win.getUser().getUsername());
				
		if(postBean.getTitolo().length()==0) {
			
			postBean.setTitolo(post.get(pos).getTitolo());
			
		} else if(postBean.getDescrizione().length()==0) {
			
			postBean.setDescrizione(post.get(pos).getDescrizione());
			
		} else if (postBean.getArgomento().length()==0) {
			
			postBean.setArgomento(post.get(pos).getArgomento());
			
		} else if (postBean.getTitolo().length()==0 && postBean.getDescrizione().length()==0 && postBean.getArgomento().length()==0) {
			
			return -1;
		}
			
			PostDAO.modifyPost(post.get(pos).getId(), postBean);
			return 1;
	}

}
