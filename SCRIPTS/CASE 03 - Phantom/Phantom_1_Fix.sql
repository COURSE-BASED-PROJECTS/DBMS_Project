--Lấy danh sách sản phẩm
CREATE 
--ALTER
PROC USP_LayDSSP_FIX
AS
BEGIN TRAN
    SET TRAN ISOLATION LEVEL SERIALIZABLE -- Prevent inserting new rows into the key range
    DECLARE @SLSP INT, @MASP VARCHAR(20), @TENSP NVARCHAR(200)
	BEGIN TRY
		DECLARE cur CURSOR DYNAMIC FOR SELECT MASP, TENSP 
                                        FROM SANPHAM
		OPEN CUR
		SET @SLSP = (SELECT COUNT(*) FROM SANPHAM)
		
      /*  SELECT @@SPID
        SELECT * FROM sys.dm_tran_locks
        WHERE request_session_id = @@SPID
		*/
		SELECT * FROM SANPHAM
        WAITFOR DELAY '0:0:05'
		

	    PRINT N'TỔNG SẢN PHẨM: ' + CAST(@SLSP AS VARCHAR(10))
		FETCH NEXT FROM CUR INTO @MASP, @TENSP
		WHILE (@@FETCH_STATUS = 0)
		BEGIN
			PRINT @MASP + ' : ' + @TENSP
			
			FETCH NEXT FROM CUR INTO @MASP, @TENSP
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
--THÊM SẢN PHẨM
--CREATE
ALTER
PROC USP_THEMSANPHAM
	@MASP CHAR(20),
	@TENSP NVARCHAR(200)
AS
BEGIN TRAN
	BEGIN TRY
		IF (NOT EXISTS(SELECT * FROM SANPHAM WHERE MASP = @MASP))
		BEGIN
			INSERT SANPHAM(MASP, TENSP)
			VALUES (@MASP, @TENSP)
		END
		ELSE 
		BEGIN
			PRINT N'SẢN PHẨM NÀY ĐÃ TỒN TẠI'
			ROLLBACK TRAN
			RETURN
		END

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