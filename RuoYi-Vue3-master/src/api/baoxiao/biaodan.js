import request from '@/utils/request'

// 查询baoxiao列表
export function listBiaodan(query) {
  return request({
    url: '/baoxiao/biaodan/list',
    method: 'get',
    params: query
  })
}

// 查询baoxiao详细
export function getBiaodan(biaodanId) {
  return request({
    url: '/baoxiao/biaodan/' + biaodanId,
    method: 'get'
  })
}

// 新增baoxiao
export function addBiaodan(data) {
  return request({
    url: '/baoxiao/biaodan',
    method: 'post',
    data: data
  })
}

// 修改baoxiao
export function updateBiaodan(data) {
  return request({
    url: '/baoxiao/biaodan',
    method: 'put',
    data: data
  })
}

// 删除baoxiao
export function delBiaodan(biaodanId) {
  return request({
    url: '/baoxiao/biaodan/' + biaodanId,
    method: 'delete'
  })
}
