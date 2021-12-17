-- Cập nhật giá của sản phẩm
CREATE
--ALTER
PROC USP_CAPNHATGIASP
    @MST CHAR(20),
	@CHINHANH CHAR(20),
    @MASP CHAR(20),
    @SOTIEN INT
AS
BEGIN TRAN
    UPDATE CUNGCAP
    SET GIASP = @SOTIEN
    WHERE   MASP = @MASP
        AND MST = @MST
        AND MACHINHANH = @CHINHANH

    WAITFOR DELAY '00:00:10'
ROLLBACK TRAN
GO

------------VẤN TIN SẢN PHẨM----------------
CREATE
--ALTER
PROC USP_VANTINSP_FIX
    @MASP CHAR(20)
AS
BEGIN TRAN
--Default ISOLATION LEVEL READ COMMITTED: ask for S lock when reading

    DECLARE @GIASP INT = 0
    BEGIN TRY
        SELECT *
        FROM CUNGCAP
        WHERE MASP = @MASP
    END TRY
    BEGIN CATCH
        DECLARE @ERRORMSG NVARCHAR(1000)
        SET @ERRORMSG = N'LỖI : ' + ERROR_MESSAGE()
        RAISERROR (@ERRORMSG, 16,1)
        ROLLBACK TRAN
        RETURN
    END CATCH
    PRINT N'VẤN TIN SẢN PHẨM THÀNH CÔNG'
COMMIT TRAN