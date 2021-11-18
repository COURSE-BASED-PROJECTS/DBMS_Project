--ĐĂNG NHẬP VÀO HỆ THỐNG
CREATE 
--ALTER 
PROC USP_DANGNHAP
	@TAIKHOAN VARCHAR(200),
	@MATKHAU VARCHAR(200)
AS
BEGIN TRAN
	BEGIN TRY
		IF(NOT EXISTS (SELECT * FROM NGUOIDUNG WHERE TAIKHOAN = @TAIKHOAN))
		BEGIN
			PRINT @TAIKHOAN + N' KHÔNG TỒN TẠI'
			ROLLBACK TRAN
			RETURN
		END

		WAITFOR DELAY '0:0:10'

		IF(NOT EXISTS(SELECT * FROM NGUOIDUNG WHERE TAIKHOAN = @TAIKHOAN AND MATKHAU = @MATKHAU))
		BEGIN
			PRINT N'SAI MẬT KHẨU'
			ROLLBACK TRAN
			RETURN
		END

		SELECT * FROM NGUOIDUNG WHERE TAIKHOAN = @TAIKHOAN AND MATKHAU = @MATKHAU
		PRINT N'ĐĂNG NHẬP THÀNH CÔNG'
	END TRY
	BEGIN CATCH
		RAISERROR (N'LỖI HỆ THỐNG',16,1)
		ROLLBACK TRAN
		RETURN
	END CATCH
COMMIT TRAN
GO

--THAY ĐỔI MẬT KHẨU
CREATE 
--ALTER 
PROC USP_DOIMATKHAU
	@TAIKHOAN VARCHAR(200),
	@MATKHAUCU VARCHAR(200),
	@MATKHAUMOI VARCHAR(200)
AS
BEGIN TRAN
	BEGIN TRY
		IF(EXISTS(SELECT * FROM NGUOIDUNG WHERE TAIKHOAN = @TAIKHOAN AND MATKHAU = @MATKHAUCU))
			UPDATE NGUOIDUNG
			SET MATKHAU = @MATKHAUMOI
			WHERE TAIKHOAN = @TAIKHOAN
		ELSE 
		BEGIN
			PRINT N'LỖI ĐĂNG NHẬP'
			ROLLBACK TRAN
			RETURN
		END
	END TRY
	BEGIN CATCH
		RAISERROR (N'LỖI HỆ THỐNG',16,1)
		ROLLBACK TRAN
		RETURN
	END CATCH
COMMIT TRAN