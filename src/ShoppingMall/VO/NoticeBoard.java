package ShoppingMall.VO;

public class NoticeBoard {
	
	//게시글 번호fdasfdsafdfasfas
	private int noticeNo;
	// 제목
	private String noticeTitle;
	// 내용
	private String noticeCont;
	
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeCont() {
		return noticeCont;
	}
	public void setNoticeCont(String noticeCont) {
		this.noticeCont = noticeCont;
	}
	
	@Override
	public String toString() {
		return "NoticeBoard [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeCont=" + noticeCont
				+ "]";
	}
	
	
	

}
