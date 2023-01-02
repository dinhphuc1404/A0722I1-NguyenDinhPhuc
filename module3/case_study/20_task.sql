use khu_nghi_duong;
-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select*from nhan_vien where (ho_ten like 'h%' or ho_ten like 'k%' or ho_ten like 't%') and char_length(ho_ten)<=15;

-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select*from khach_hang where(timestampdiff(year,ngay_sinh,now()) between 18 and 50) 
and (dia_chi like '%Da Nang%' or dia_chi like '%Quang Tri%');

-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select ma_khach_hang, ho_ten, count(ma_khach_hang) as so_lan_dat_phong
from khach_hang join loai_khach using (ma_loai_khach) join hop_dong using(ma_khach_hang)
where ten_loai_khach = 'Diamond'
group by ma_khach_hang 
order by so_lan_dat_phong;

-- 5.Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien
-- (Với tổng tiền được tính theo công thức như sau: 
-- Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet)
--  cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,
if (hdct.ma_hop_dong is null, chi_phi_thue, chi_phi_thue + sum(so_luong*gia)) as 'Tổng tiền' from khach_hang kh
inner join loai_khach using(ma_loai_khach) 
left join hop_dong using(ma_khach_hang) left join hop_dong_chi_tiet hdct using(ma_hop_dong) left join dich_vu_di_kem using(ma_dich_vu_di_kem) 
left join dich_vu using(ma_dich_vu)
group by ma_khach_hang, ma_hop_dong
order by ma_khach_hang;

-- 6.Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu
from dich_vu join loai_dich_vu using (ma_loai_dich_vu)
where ma_dich_vu not in ( select ma_dich_vu from dich_vu join hop_dong using (ma_dich_vu) 
	where ngay_lam_hop_dong between '2021-01-01' and '2021-03-31')
order by dien_tich desc;

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
where exists(select hop_dong.ma_hop_dong from hop_dong	where year(hop_dong.ngay_lam_hop_dong) = '2020' 
and hop_dong.ma_dich_vu = dich_vu.ma_dich_vu)
and not exists(select hop_dong.ma_hop_dong from hop_dong where year(hop_dong.ngay_lam_hop_dong) = '2021' 
and hop_dong.ma_dich_vu = dich_vu.ma_dich_vu);

-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
select distinct ho_ten from khach_hang;
select ho_ten from khach_hang group by ho_ten;
select ho_ten from khach_hang union select ho_ten from khach_hang;

-- 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select temp.month,so_luong_khach_hang   from
(select 1 as month 
union select 2 as month
union select 3 as month
union select 4 as month
union select 5 as month
union select 6 as month
union select 7 as month
union select 8 as month
union select 9 as month
union select 10 as month
union select 11 as month
union select 12 as month) as temp
left join ( select month(ngay_lam_hop_dong) as month,
			count(ma_khach_hang) as so_luong_khach_hang 
		from hop_dong where year(ngay_lam_hop_dong)= '2021'
		group by month) as co using(month);

-- 10.Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select
    hop_dong.ma_hop_dong,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    sum(hop_dong.tien_dat_coc) tong_tien_coc,
    ifnull(sum(hop_dong_chi_tiet.so_luong), 0) so_luong_dich_vu_di_kem
from
    hop_dong 
    left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by
    hop_dong.ma_hop_dong;

-- 11.Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” 
-- và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select ma_dich_vu_di_kem, ten_dich_vu_di_kem from dich_vu_di_kem
    join hop_dong_chi_tiet using (ma_dich_vu_di_kem)
    join hop_dong hd using (ma_hop_dong)
    join khach_hang using (ma_khach_hang)
    join loai_khach using (ma_loai_khach)
where ten_loai_khach = 'Diamond' and ( dia_chi like '%Vinh%' or dia_chi like '%Quãng Ngãi%');

-- 12.Hiển thị thông tin ma_hop_dong,ho_ten(nhân viên),ho_ten(khách hàng),so_dien_thoai(khách hàng),ten_dich_vu,so_luong_dich_vu_di_kem
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, ma_dich_vu, ten_dich_vu, sum(so_luong) so_luong_dich_vu_di_kem, sum(tien_dat_coc) tien_dat_coc
from hop_dong
    left join nhan_vien nv using (ma_nhan_vien)
    left join dich_vu using (ma_dich_vu)
    left join khach_hang kh using (ma_khach_hang)
    left join hop_dong_chi_tiet using (ma_hop_dong)
    left join dich_vu_di_kem using (ma_dich_vu_di_kem)
where( ngay_lam_hop_dong between '2020-10-01' and '2020-12-30') and (ngay_lam_hop_dong not between '2021-01-01' and '2021-06-30')
group by ma_hop_dong;

-- 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
with count_used as ( select ma_dich_vu_di_kem, ten_dich_vu_di_kem, sum(so_luong) so_luong_dich_vu_di_kem from dich_vu_di_kem
	join hop_dong_chi_tiet using(ma_dich_vu_di_kem)
    group by ma_dich_vu_di_kem)
select ma_dich_vu_di_kem, ten_dich_vu_di_kem, so_luong_dich_vu_di_kem from count_used
where so_luong_dich_vu_di_kem = ( select max(so_luong_dich_vu_di_kem) from count_used);

-- 14.Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung
--  (được tính dựa trên việc count các ma_dich_vu_di_kem).

-- 15.Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi, count(hd.ma_nhan_vien) tong_so_hop_dong from nhan_vien
    join trinh_do using (ma_trinh_do)
    join bo_phan using (ma_bo_phan)
    join hop_dong hd using (ma_nhan_vien)
where year(ngay_lam_hop_dong) between 2020 and 2021
group by hd.ma_nhan_vien
having tong_so_hop_dong <= 3
order by ma_nhan_vien;

-- 20.Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_nhan_vien as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from nhan_vien
union all
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh,dia_chi from khach_hang;


    











