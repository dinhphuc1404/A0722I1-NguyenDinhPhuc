use quan_ly_sinh_vien;
-- các hàm thông dụng trong SQL
-- thực hành
-- Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
select address , count(student_id) as 'Số lượng học viên' from student group by address;
-- Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
select s.student_id , s.student_name, avg(mark) from student s join mark m on s.student_id = m.student_id 
group by s.student_id, s.student_name;
-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
-- Đầu tiên hiển thị điểm trung bình các môn học của mỗi học viên
-- Sử dụng having để xét điều kiện điểm trung bình các môn học phải lớn hơn 15
select s.student_id, s.student_name, avg(mark) 
from student s join mark m on s.student_id = m.student_id
group by s.student_id, s.student_name having avg(mark)>15;
-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
--  bước 1 Hiển thị danh sách điểm trung bình của các học viên
select s.student_id , s.student_name, avg(mark) from student s join mark m on s.student_id = m.student_id 
group by s.student_id, s.student_name;
-- bước 2 Sử dụng Having và All để tìm học viên có điểm trung bình lớn nhất
select s.student_id , s.student_name, avg(mark) from student s join mark m on s.student_id = m.student_id 
group by s.student_id, s.student_name having avg(mark) >= all (select avg(mark) from mark group by mark.student_id);