# mybatis常用sql模板

## 多表联查

   方式一：

```xml

 <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="com.xxx.project.domain.CaseSurvey">
        <id column="id" property="id" />
        <result column="member_id" property="memberId" />
        <result column="member_type" property="memberType" />
        <result column="case_id" property="caseId" />
        <result column="create_time" property="createTime" />
        <result column="create_by" property="createBy" />
        <result column="update_time" property="updateTime" />
        <result column="update_by" property="updateBy" />
        <result column="remark" property="remark" />
        <association property="caseInfo" column="case_id"  select="com.xxx.project.mapper.CaseInfoMapper.selectById"/>
        <association property="survey" column="member_id"  select="com.xxx.system.mapper.SurveyUserMapper.getSurveyByUserId"/>
    </resultMap>

    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
        id, member_id AS memberId, member_type AS memberType, case_id AS caseId, create_time AS createTime, create_by AS createBy, update_time AS updateTime, update_by AS updateBy, remark
    </sql>

    <select id="selectList" resultMap="BaseResultMap" >
        select * from t_case_survey where case_id = #{caseId}
    </select>



```

方式二：

```xml
<resultMap id="CaseUserResultMap" type="com.hcly.project.domain.CaseInfo">
        <id column="id" property="id"/>
        <result column="case_number" property="caseNumber"/>
        <result column="case_name" property="caseName"/>
        <result column="case_source" property="caseSource"/>
        <result column="case_desc" property="caseDesc"/>
        <result column="command_room_id" property="commandRoomId"/>
        <result column="status" property="status"/>
        <result column="arrive_time" property="arriveTime"/>
        <result column="create_time" property="createTime"/>
        <result column="create_by" property="createBy"/>
        <result column="update_time" property="updateTime"/>
        <result column="update_by" property="updateBy"/>
        <result column="remark" property="remark"/>
        <collection property="liens" javaType="java.util.List" ofType="LienInfo"  >
            <id column="lienId" property="id"/>
            <result column="code" property="code"/>
        </collection>
    </resultMap>
```



# 查询添加条件

```xml
        <where>
            <if test="t.id != null and t.id != ''">
                AND t.id = #{t.id}
            </if>
            <if test="t.caseNumber != null and t.caseNumber != ''">
                AND t.case_number like concat('%', #{t.caseNumber}, '%')
            </if>
            <if test="t.createTime != null">
                AND date_format(t.create_time,'%y%m%d') = date_format(#{t.createTime},'%y%m%d')
            </if>
            <if test="t.sList != null and t.sList.length > 0">
                AND t1.status in
                <foreach collection="t.sList" item="status" open="(" separator="," close=")">
                    #{status}
                </foreach>
            </if>
        </where>
```

