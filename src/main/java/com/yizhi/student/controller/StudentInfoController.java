package com.yizhi.student.controller;

import com.yizhi.common.annotation.Log;
import com.yizhi.common.utils.*;
import com.yizhi.student.domain.StudentInfoDO;
import com.yizhi.student.service.StudentInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 生基础信息表
 */
 
@Controller
@RequestMapping("/student/studentInfo")
public class StudentInfoController {

	@Autowired
	private StudentInfoService studentInfoService;

	@Log("学生信息保存")
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("student:studentInfo:add")
	public R someMethod(StudentInfoDO studentInfo) {
		// 检查参数是否为空
		if (studentInfo == null) {
			System.out.println("学生信息不能为空！");
			return R.error("学生信息不能为空！");
		}

		// 检查学生姓名是否为空
		if (StringUtils.isBlank(studentInfo.getStudentName())) {
			System.out.println("学生姓名不能为空！");
			return R.error("学生姓名不能为空！");

		}

		// 检查身份证号格式是否正确
		if (!IdCardUtil.validateCard(studentInfo.getCertify())) {
			System.out.println("身份证号格式不正确！");
			return R.error("身份证号格式不正确！");
		}

		// 检查手机号格式是否正确
		if (!PhoneUtil.isMobileExact(studentInfo.getTelephone())) {
			System.out.println("手机号格式不正确！");
			return R.error("手机号格式不正确！");
		}

		// 其实还可以查询其他班级、专业、学院是否存在，这里我不做判断了
		System.out.println(studentInfo);

		// 调用保存方法进行保存
		studentInfoService.save(studentInfo);
		return R.ok("保存成功！");
	}

	/**
	 * 查询学生信息列表
	 * @param params 请求参数，包含currPage、pageSize、name、tocollegeId、tomajorId、classId等字段
	 * @return PageUtils对象，包含查询结果和分页信息
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("student:studentInfo:studentInfo")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 获取当前页码和每页显示的数据量
		int pageNum = Integer.parseInt(params.get("currPage").toString());
		int pageSize = Integer.parseInt(params.get("pageSize").toString());

		// 将params中的当前页码和每页显示的数据量转换成Integer
		params.put("pageNum", pageNum);
		params.put("pageSize", pageSize);


		// 计算偏移量
		int offset = (pageNum - 1) * pageSize;
		params.put("offset", offset);
		// 调用Service层的list方法查询符合条件的学生信息列表
		List<StudentInfoDO> list = studentInfoService.list(params);
		// 统计符合条件的数据总数
		int total = studentInfoService.count(params);
		// 将查询结果和分页信息封装到PageUtils对象中并返回
		return new PageUtils(list, total, pageSize, pageNum);
	}




	/**
	 * 修改
	 */
	@Log("学生基础信息表修改")
	@ResponseBody
	@PostMapping("/update")
	@RequiresPermissions("student:studentInfo:edit")
	public R update(StudentInfoDO studentInfo){

		return null;
	}

	/**
	 * 删除
	 */
	@Log("学生基础信息表删除")
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("student:studentInfo:remove")
	public R remove( Integer id){
		return null;
	}
	
	/**
	 * 批量删除
	 */
	@Log("学生基础信息表批量删除")
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("student:studentInfo:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){

		return null;
	}


	//前后端不分离 客户端 -> 控制器-> 定位视图
	/**
	 * 学生管理 点击Tab标签 forward页面
	 */
	@GetMapping()
	@RequiresPermissions("student:studentInfo:studentInfo")
	String StudentInfo(){
		return "student/studentInfo/studentInfo";
	}

	/**
	 * 更新功能 弹出View定位
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("student:studentInfo:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		StudentInfoDO studentInfo = studentInfoService.get(id);
		model.addAttribute("studentInfo", studentInfo);
		return "student/studentInfo/edit";
	}

	/**
	 * 学生管理 添加学生弹出 View
	 */
	@GetMapping("/add")
	@RequiresPermissions("student:studentInfo:add")
	String add(){
	    return "student/studentInfo/add";
	}
	
}//end class
