;;; Number 1
(write-line "What is your name?")
(defvar *name* (read))
(defun welcome (*name*)
        (format t "Hello ~a, Welcome to CS3342!~%" *name*)
)

(welcome *name*)

;;; Number 2
(write-line "")
(write-line "What is the age?")

(defparameter *age* (read))
(defvar *college-ready* nil)
(cond ( (>= *age* 18) 
            (setf *college-ready* 'yes)
            (format t "Ready for College ~%"))
        ( (< *age* 18)
            (setf *college-ready* 'no)
            (format t "Not Ready for College ~%"))
 )
 
 ;;; Number 3
 
 (defun factorial (n)
   (cond
     ((= n 1) 1)
     (t (* n (factorial (- n 1))))))
     

(write-line "Enter a number please?")
(defparameter *num* (read))
(princ "The factorial of ")
(princ *num*)
(write-line " is ")
(write (factorial *num*))

;;;Number 4

(defun fib (n)
 (if (< n 2)
 n
 (+ (fib (- n 1)) (fib (- n 2)))))

(defun fibs (??)
 (loop for I from 1 to ??
    collect (fib I)))
    
(write-line "How many Fibonacci number do you like to have?")
(defparameter *fibNum* (read))
(princ "The following are the ")
(princ *fibNum*)
(write-line " Fibonacci numbers.")
(write (fibs *fibNum*))

;;;Number 5

(write-line "This is the list:")

(loop for x in '(superman batman aquaman flash joker) do
    (format t "~s ~%" x)
)

(format t "4th Item = ~a ~%" (cadddr '(superman batman aquaman flash joker)))