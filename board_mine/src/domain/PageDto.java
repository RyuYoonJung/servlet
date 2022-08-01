package domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDto {
	private static final int PAGE_COUNT = 10;  // 하단에 페이지 몇개 보여줄지
	
	private int start;  // 시작숫자 
	private int end;  // 종료숫자
	private int total;  // 게시글 총갯수
	private boolean next; // 다음페이지 가능여부
	private boolean prev; // 이전페이지 가능여부
	private Criteria cri;  // pageNum, amount, category

	public PageDto(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;

//		end = (5 + (10-1)) / 10 * 10;
		end = (cri.getPageNum() + (PAGE_COUNT-1)) / PAGE_COUNT * PAGE_COUNT;
		start = end - PAGE_COUNT + 1;
		int realEnd = (total + (cri.getAmount()-1)) / cri.getAmount();
		if(realEnd < end) {
			end = realEnd;
		}
		prev = cri.getPageNum() > 1;
		next = cri.getPageNum() < realEnd;
		
	}
	
	public static void main(String[] args) {
		PageDto dto = new PageDto(126, new Criteria(1, 10 ,1));
	}
}









