package com.itwillbs.mvc_board.vo;
//페이징 처리에 사용될 정보를 저장할 PageInfo 클래스 정의(=DTO = Bean = VO 역할)

public class PageInfo {

	private int listCount; //총 게시물 수
	private int pageListLimit;
	private int maxPage;
	private int startPage;
	private int endPage;
	
	//기본생성자 정의
	public PageInfo() {
		super();
	}

	//파라미터 생성자 정의
	public PageInfo(int listCount, int pageListLimit, int maxPage, int startPage, int endPage) {
		super();
		this.listCount = listCount;
		this.pageListLimit = pageListLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	
	//getter / setter
	public int getListCount() {
		return listCount;
	}
	
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	public int getPageListLimit() {
		return pageListLimit;
	}
	
	public void setPageListLimit(int pageListLimit) {
		this.pageListLimit = pageListLimit;
	}
	
	public int getMaxPage() {
		return maxPage;
	}
	
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	
}
