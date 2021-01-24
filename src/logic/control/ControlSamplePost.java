package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.bean.PostBean;
import logic.dao.PostDAO;
import logic.entity.Post;
import logic.utils.WindowManagerGUI;

public class ControlSamplePost {
	
	public int insertSamplePost(PostBean postBean) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		if(postBean.getTitolo().length()==0 || postBean.getDescrizione().length()==0) {
			
			return -1;
			
		} else {
			
			Post post = new Post();
			
			post.setAutore(win.getUser().getUsername());
			
			post.setTitolo(postBean.getTitolo());
			post.setDescrizione(postBean.getDescrizione());
			post.setNomeSample(postBean.getNomeSample());
					
			PostDAO.insertPost(post);

		/*	try {
				Files.copy(Paths.get(fl.getCanonicalPath()), Paths.get(
						"C:\\Users\\987018\\Desktop\\ISPW\\Progetto Social-Music\\Codice\\SocialMusic\\DB - Samples\\ "
								+ fl.getName()));
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			
			return 1;
		}
	}
	
	public List<PostBean> filterSamplePostByUsername(String username) {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<PostBean>();
		
		
		for (i = 0; i < post.size(); i++) {
						
			if(post.get(i).getAutore().equals(username) && !post.get(i).getNomeSample().equals("null")) {
								
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getId());
				postBean.setTitolo(post.get(i).getTitolo());
				postBean.setAutore(post.get(i).getAutore());
				postBean.setDescrizione(post.get(i).getDescrizione());
				postBean.setNomeSample(post.get(i).getNomeSample());
				
				postBeanList.add(postBean);
				
			}
		}
		
		return postBeanList;
	
	}
	
	public int removeSamplePost(int num) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		List<PostBean> post = filterSamplePostByUsername(win.getUser().getUsername());
		
		if(num>=0 && num<post.size()) {
						
			PostDAO.deletePost(post.get(num).getId());
			return 1;
			
		} else {
			
			return -1;
		}
		
	}

	public int modifySamplePost(PostBean postBean, int pos) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		List<PostBean> post = filterSamplePostByUsername(win.getUser().getUsername());
		
		//i=post.get(pos).getId();
		
		if(postBean.getTitolo().length()==0) {
			
			postBean.setTitolo(post.get(pos).getTitolo());
			
		} else if(postBean.getDescrizione().length()==0) {
			
			postBean.setDescrizione(post.get(pos).getDescrizione());
		} else if (postBean.getTitolo().length()==0 && postBean.getDescrizione().length()==0) {
			return -1;
		}
		
		/*for(i=0;i<post.size();i++) {
			
			if(post.get(i).getId()==pos) {
				
				if(postBean.getTitolo().length()==0) {
					
					postBean.setTitolo(post.get(i).getTitolo());
					
				} else if(postBean.getDescrizione().length()==0) {
					
					postBean.setDescrizione(post.get(i).getDescrizione());
				}
				
			}
		}*/
		
	//	if(pos>=0 && pos<post.size()) {
			
			PostDAO.modifyPost(post.get(pos).getId(), postBean);
			return 1;
			
	/*	} else {
			
			modifySamplePostErrorAlert();
		}		*/
	}

	public int checkId(int pos) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		List<PostBean> post = filterSamplePostByUsername(win.getUser().getUsername());
		
		if(pos<0 || pos>post.size() ) {
			
			return -1;
		}
		
		return pos;
	}

	public List<PostBean> getSamplePosts() {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<PostBean>();		
		
		for (i = 0; i < post.size(); i++) {
			
			if(!post.get(i).getNomeSample().equals("null")) {
				
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getId());
				postBean.setTitolo(post.get(i).getTitolo());
				postBean.setAutore(post.get(i).getAutore());
				postBean.setDescrizione(post.get(i).getDescrizione());
				postBean.setNomeSample(post.get(i).getNomeSample());

				postBeanList.add(postBean);	
			}
				
		}
		
		return postBeanList;
	}
	
}
