--ĐỐI TÁC TRUY VẤN HỢP ĐỒNG VỚI THỜI GIAN BẮT ĐẦU
--CREATE 
ALTER 
PROC USP_TRUYVANHD
	@MADT CHAR(20),
	@HETHAN DATETIME
	
AS
BEGIN TRAN
	SET TRAN ISOLATION LEVEL REPEATABLE READ -- get S, keep until commit

	BEGIN TRY
		IF(NOT EXISTS (SELECT * FROM HOPDONG WHERE MST = @MADT))
		BEGIN
			PRINT N'KHÔNG TÌM THẤY HỢP ĐỒNG CỦA ĐỐI TÁC ' + @MADT
			ROLLBACK TRAN
			RETURN
		END
		
		WAITFOR DELAY '0:0:05'
		
		IF(NOT EXISTS (SELECT * FROM HOPDONG WHERE MST = @MADT AND THGIANHIEULUC = @HETHAN))
		BEGIN
			PRINT N'KHÔNG TÌM THẤY HỢP ĐỒNG CÓ HIỆU LỰC ĐẾN NGÀY ' + CAST(@HETHAN AS VARCHAR(20))
			ROLLBACK TRAN
			RETURN
		END
		
		SELECT * FROM HOPDONG WHERE MST = @MADT AND THGIANHIEULUC = @HETHAN

	END TRY
	BEGIN CATCH
		RAISERROR (N'LỖI HỆ THỐNG',16,1)
		ROLLBACK TRAN
		RETURN
	END CATCH
COMMIT TRAN
GO


--THAY ĐỔI THỜI GIAN HIỆU LỰC CHO HỢP ĐỒNG
--CREATE 
ALTER 
PROC USP_GIAHANHD
	@MAHD CHAR(20),
	@THOIHANCU CHAR(10),
	@THOIHANMOI CHAR(10)
AS
BEGIN TRAN
	SET TRAN ISOLATION LEVEL REPEATABLE READ -- get S, keep until commit

	BEGIN TRY
		IF(EXISTS(SELECT * FROM HOPDONG WHERE MAHD = @MAHD AND THGIANHIEULUC = @THOIHANCU))
			UPDATE HOPDONG
			SET THGIANHIEULUC = @THOIHANMOI, KICHHOAT = 1
			WHERE MAHD = @MAHD
		ELSE 
		BEGIN
			PRINT N'KHÔNG TÌM THẤY HỢP ĐỒNG CÓ HIỆU LỰC NGÀY ' + CAST(@THOIHANCU AS VARCHAR(20))
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