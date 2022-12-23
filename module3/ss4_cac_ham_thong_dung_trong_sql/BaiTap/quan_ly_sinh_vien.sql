use quan_ly_sinh_vien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject where credit =( select max(credit) from subject);
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select * from subject join mark on subject.sub_id = mark.sub_id 
where mark.mark = (select max(mark.mark) from mark);
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.student_id, s.student_name, s.address, s.phone, s.status, avg(mark) as "điểm trung bình"
from student s join mark m using (student_id) 
group by s.student_id order by avg(mark) desc;