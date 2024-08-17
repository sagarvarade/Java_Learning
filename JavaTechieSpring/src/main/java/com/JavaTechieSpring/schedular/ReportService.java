package com.JavaTechieSpring.schedular;

import com.JavaTechieSpring.DTO.CourseResponseDTO;
import com.JavaTechieSpring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private CourseService courseService;

    public List<CourseResponseDTO> getAllCourses() {
        return courseService.viewAllCourses();
    }
/*
    public byte[] generateReport(List<CourseResponseDTO> courseResponseDTOS) throws Exception {
        try(SXSSFWorkbook workbook = new SXSSFWorkbook()) {
            // Create a sheet in the workbook
            Sheet sheet = workbook.createSheet("Example Sheet");
            writeHeaderLine(sheet);
            int rowCount=0;
            CellStyle style=workbook.createCellStyle();
            XSSFFont font=(XSSFFont) workbook.createFont();
            font.setFontHeight(14);
            style.setFont(font);
            for(CourseResponseDTO course:courseResponseDTOS){
                Row row=sheet.createRow(rowCount++);
                int columnCount=0;
                createCell(row,columnCount++,course.getName(),style);
                createCell(row,columnCount++,course.getTrainerName(),style);
                createCell(row,columnCount++,course.getDuration(),style);
                createCell(row,columnCount++,String.valueOf(course.getStartDate()),style);
                createCell(row,columnCount++,String.valueOf(course.getFees()),style);
                createCell(row,columnCount++,course.getDuration(),style);
                createCell(row,columnCount++,course.getCourseUniqueCode(),style);
                createCell(row,columnCount++,course.getEmail(),style);
                createCell(row,columnCount++,course.getContact(),style);
            }
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            try {
                workbook.write(bos);
            }catch (Exception e){
                e.printStackTrace();
            }
            workbook.dispose();
            return  bos.toByteArray();
        }
    }

    private void writeHeaderLine(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("name");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("trainerName");
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("duration");
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("startDate");
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("fees");
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("description");
        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("courseUniqueCode");
        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("email");
        headerCell = headerRow.createCell(9);
        headerCell.setCellValue("contact");
        headerCell = headerRow.createCell(10);
        headerCell.setCellValue("courseType");
    }
    *
 */
}
