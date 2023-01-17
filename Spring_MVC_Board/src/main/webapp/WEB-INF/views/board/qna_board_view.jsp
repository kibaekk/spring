<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
	#articleForm {
		width: 500px;
		height: 550px;
		border: 1px solid red;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		border: 1px solid black;
		border-collapse: collapse; 
	 	width: 500px;
	}
	
	th {
		text-align: center;
	}
	
	td {
		width: 150px;
		text-align: center;
	}
	
	#basicInfoArea {
		height: 70px;
		text-align: center;
	}
	
	#articleContentArea {
		background: orange;
		margin-top: 20px;
		height: 350px;
		text-align: center;
		overflow: auto;
		white-space: pre-line;
	}
	
	#commandList {
		margin: auto;
		width: 500px;
		text-align: center;
	}
</style>
</head>
<body>
	<!-- 게시판 상세내용 보기 -->
	<section id="articleForm">
		<h2>글 상세내용 보기</h2>
		<section id="basicInfoArea">
			<table border="1">
			<tr><th width="70">제 목</th><td colspan="3" >${board.board_subject }  </td></tr>
			<tr>
				<th width="70">작성자</th><td>${board.board_name}  </td>
				<th width="70">작성일</th>
				<td> <fmt:formatDate value="${board.board_date }" pattern="yy-MM-dd HH:mm:SS"></fmt:formatDate> </td>
				
			</tr>
			<tr>
				<th width="70">첨부파일</th>
				<td> <a href="upload/${board.board_realfile }" download="${board.board_file }">${board.board_file }</a></td>
				
				<th width="70">조회수</th>
				<td>${board.board_readcount}</td>
			</tr>
			</table>
		</section>
		<section id="articleContentArea">
			<!-- 본문 표시 -->
			${board.board_content }
			
		</section>
	</section>
	<section id="commandList">
		<input type="button" value="답변" onclick="location.href='BoardReplyForm.bo?board_num=${param.board_num }&pageNum=${param.pageNum }'">
		<input type="button" value="수정" onclick="location.href='BoardModifyForm.bo?board_num=${param.board_num }&pageNum=${param.pageNum }'">
		<input type="button" value="삭제" onclick="location.href='BoardDeleteForm.bo?board_num=${param.board_num }&pageNum=${param.pageNum }'">
		<input type="button" value="목록" onclick="location.href='BoardList.bo?pageNum=${param.pageNum }'">
	</section>
</body>
</html>
















