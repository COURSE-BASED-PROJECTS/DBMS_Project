--Lấy danh sách các đối tác đã đăng ký
CREATE 
--ALTER
PROC USP_LayDSDT
AS
BEGIN TRAN
--default isolation level: not prevent T2 insert new rows
    DECLARE @SLDT INT,@MST CHAR(20),@DAIDIEN NVARCHAR(50),@TENDT NVARCHAR(50)
	BEGIN TRY
		DECLARE cur CURSOR DYNAMIC FOR SELECT MST, NGUOIDAIDIEN, TENDT FROM DOITAC
		OPEN CUR
		SET @SLDT = (SELECT COUNT(*) FROM DOITAC)
		
        WAITFOR DELAY '0:0:10'

	    PRINT N'TỔNG SỐ ĐỐI TÁC HIỆN CÓ: ' + CAST(@SLDT AS VARCHAR(10))
		PRINT N'DANH SÁCH CÁC ĐỐI TÁC ĐÃ KÝ HỢP ĐỒNG'
		PRINT SPACE(4) + 'MST'  + SPACE(15) + N'TÊN ĐỐI TÁC' +  SPACE(3) + N'NGƯỜI ĐẠI DIỆN'
		
		FETCH NEXT FROM CUR INTO @MST, @DAIDIEN, @TENDT
		WHILE (@@FETCH_STATUS = 0)
		BEGIN
			PRINT @MST + ' : ' + @TENDT  + char(9) + ' ; ' +  @DAIDIEN
			--WAITFOR DELAY '0:0:02'
			FETCH NEXT FROM CUR INTO @MST, @DAIDIEN, @TENDT
		END
		CLOSE CUR
		DEALLOCATE CUR
	END TRY
	BEGIN CATCH
		DECLARE @ErrorMsg VARCHAR(2000)
		SELECT @ErrorMsg = N'Lỗi: ' + ERROR_MESSAGE()
		RAISERROR(@ErrorMsg, 16,1)
		ROLLBACK TRAN
		RETURN
	END CATCH
COMMIT TRAN

GO
--THÊM ĐỐI TÁC--
CREATE
--ALTER
PROC USP_THEMDOITAC
	@MST CHAR(20),
	@DAIDIEN NVARCHAR(50),
	@TENDT NVARCHAR(50),
	@SLCN INT,
	@LOAIHANG NVARCHAR(50),
	@DIACHI NVARCHAR(200),
	@SDT CHAR(10),
	@EMAIL CHAR(50)
AS
BEGIN TRAN
	BEGIN TRY
		IF (NOT EXISTS(SELECT * FROM DOITAC WHERE MST = @MST))
		BEGIN
			INSERT DOITAC(MST,NGUOIDAIDIEN,TENDT,SLCHINHANH,LOAIHANG,DIACHI,SDT,EMAIL)
			VALUES (@MST,@DAIDIEN,@TENDT,@SLCN,@LOAIHANG,@DIACHI,@SDT,@EMAIL)
		END
		ELSE 
		BEGIN
			PRINT N'ĐỐI TÁC NÀY ĐÃ TỒN TẠI'
			ROLLBACK TRAN
			RETURN
		END
		--WAITFOR DELAY '0:0:05'
	END TRY
	BEGIN CATCH
		DECLARE @ErrorMsg VARCHAR(2000)
		SELECT @ErrorMsg = N'Lỗi: ' + ERROR_MESSAGE()
		RAISERROR(@ErrorMsg, 16,1)
		ROLLBACK TRAN
		RETURN
	END CATCH
	PRINT N'ĐÃ THÊM THÀNH CÔNG'
COMMIT TRAN
GO