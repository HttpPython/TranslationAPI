package net.httppython.language

import org.simpleyaml.configuration.file.YamlFile

class Language (lang : String, path : String){

    private val lang = lang
    private val path = path
    private var file : YamlFile = YamlFile(path)

    fun create() {
        if(file.exists()) return
        file.createNewFile()
    }

    fun delete() {
        if(!file.exists()) return
        file.deleteFile()
    }

    fun createTranslation(key : String) {
        if(file.contains(key)) return
        file.set(key, "Translation not set!")
        file.save()
    }

    fun setTranslation(key : String, translation : String) {
        if(!file.contains(key)) return
        file.set(key, translation)
        file.save()
    }

    fun deleteTranslation(key : String) {
        if(!file.contains(key)) return
        file.remove(key)
        file.save()
    }

    fun changeKey(key: String, newKey : String) {
        if(!file.contains(key)) return
        file.set(key, newKey)
        file.save()
    }

    fun get(): Language {
        return this
    }

}