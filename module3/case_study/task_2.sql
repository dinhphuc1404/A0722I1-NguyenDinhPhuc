use khu_nghi_duong;
-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select*from nhan_vien where (ho_ten like 'h%' or ho_ten like 'k%' or ho_ten like 't%') and char_length(ho_ten)<=15;