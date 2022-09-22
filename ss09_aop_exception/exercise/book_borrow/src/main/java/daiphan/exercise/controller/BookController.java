package daiphan.exercise.controller;

import daiphan.exercise.exception.BorrowException;
import daiphan.exercise.exception.PayException;
import daiphan.exercise.model.Book;
import daiphan.exercise.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping("")
    public String showList(@PageableDefault(value = 5)Pageable pageable, Model model){
        model.addAttribute("books", bookService.findAll(pageable));
        return "index";
    }

    @GetMapping("/{id}/borrow")
    public String updateBorrowBook(@PathVariable int id, RedirectAttributes redirectAttributes) throws BorrowException {
        Book book = bookService.findById(id);
        if(book!=null ){
            if(book.getQuantity()>0){
                bookService.borrowBook(book);
                redirectAttributes.addFlashAttribute("success","mượn sách "+ book.getName()+" thành công");
            }else{
                throw new BorrowException();
            }
        }
        return "redirect:/book";
    }

    @GetMapping("/{id}/pay")
    public String updatePayBook(@PathVariable int id, RedirectAttributes redirectAttributes) throws PayException {
        Book book = bookService.findById(id);
        if(book!=null ){
                bookService.payBook(book);
            redirectAttributes.addFlashAttribute("success","trả sách "+ book.getName()+"  thành công");
        }else{
            throw new PayException();
        }
        return "redirect:/book";
    }

    @ExceptionHandler(BorrowException.class)
    public String  showBorrowException(){
        return "/borrow";
    }

    @ExceptionHandler(PayException.class)
    public String  showPayException(){
        return "/pay";
    }
}
