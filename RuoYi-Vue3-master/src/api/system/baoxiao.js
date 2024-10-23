import request from '@/utils/request'

// 查询报销列表
export function sendmsg(query) {
  return request({
    url: '/system/baoxiao/sendmsg',
    method: 'get',
    params: query
  }).catch(error => {
    console.error('请求错误:', error.response || error);
    throw error;
  });
}
