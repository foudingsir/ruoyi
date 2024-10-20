import request from '@/utils/request'

// 查询报销列表
export function list(query) {
  return request({
    url: '/system/baoxiao/list',
    method: 'get',
    params: query
  })
}