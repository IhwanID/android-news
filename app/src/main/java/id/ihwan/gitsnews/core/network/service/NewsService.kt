package id.ihwan.gitsnews.core.network.service

import id.ihwan.gitsnews.core.network.Network

interface NewsService {

    companion object {
        var instance: NewsService? = null

        fun instance() : NewsService{
            instance?.let {
                return it
            }?: return createInstance()
        }

        private fun createInstance(): NewsService{
            instance = Network.createService(NewsService::class.java)
            return instance!!
        }

        fun removeInstance(){
            instance = null
        }
    }

}