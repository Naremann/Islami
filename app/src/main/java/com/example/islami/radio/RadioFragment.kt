package com.example.islami.radio

import android.app.ProgressDialog
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.api.ApiManager
import com.example.islami.database.MyDatabase
import com.example.islami.model.RadiosItem
import com.example.islami.repos.radio.*
import kotlinx.coroutines.launch

class RadioFragment : Fragment() {
    private var audioList: List<RadiosItem?>? = null
    private lateinit var playIcon: ImageView
    private lateinit var pauseIcon: ImageView
    private lateinit var previousIcon: ImageView
    private lateinit var nextIcon: ImageView
    private lateinit var readerName: TextView
    private lateinit var readerTv: TextView
    private lateinit var progressDialog: ProgressDialog
    private lateinit var url: String
    private lateinit var reader: String
    private var mediaPlayer: MediaPlayer? = null
    private var quranAudioRepository: QuranAudioRepository
    private var offlineDataSource: QuranAudioOfflineDAtaSource
    private var onlineDataSource: QuranAudioOnlineDAtaSource

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }


    override fun onStart() {
        super.onStart()
        if (Constants.iS_PAUSE) {
            progressDialog.dismiss()
            pauseIcon.isVisible = true
            playIcon.isVisible = false
            readerTv.isVisible = true
            readerName.text = Constants.READER_NAME

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initProgressDialog()
        initViews()
        getAudioResponse()

        playIcon.setOnClickListener {
            Log.e("onPlayIc", "audio_list$audioList")
            playRadio(Constants.AUDIO_INDEX)


        }
        pauseIcon.setOnClickListener {
            stopPlaying()
        }
        previousIcon.setOnClickListener {
            playPreviousAudio()

        }
        nextIcon.setOnClickListener {
            playNextAudio()
        }
    }

    private fun initProgressDialog() {
        progressDialog = ProgressDialog(requireContext())
        progressDialog.setCancelable(false)
    }

    private fun playPreviousAudio() {
        Log.e("playAudio", "list$audioList")
        if (Constants.AUDIO_INDEX == 0) {
            Log.e("next_ic", "list" + audioList!![Constants.AUDIO_INDEX]!!.id)
            playRadio(Constants.AUDIO_INDEX)

        } else {
            Log.e("next_ic", "list" + audioList!![Constants.AUDIO_INDEX]!!.id)
            playRadio(Constants.AUDIO_INDEX - 1)
        }
    }

    private fun playNextAudio() {
        if (Constants.AUDIO_INDEX == audioList!!.size - 1) {
            Log.e("next_ic", "list" + audioList!![Constants.AUDIO_INDEX]!!.id)
            playRadio(Constants.AUDIO_INDEX)
        } else {
            Log.e("next_ic", "list" + audioList!![Constants.AUDIO_INDEX]!!.id)
            playRadio(Constants.AUDIO_INDEX + 1)
        }
    }


    private fun playMediaPlayer(url: String) {
        stopPlaying()
        playIcon.isVisible = false
        Constants.iS_PLAY = playIcon.isVisible
        pauseIcon.isVisible = true
        Constants.iS_PAUSE = pauseIcon.isVisible
        readerTv.isVisible = true
        Constants.iS_VIEW_READER_NAME = readerTv.isVisible
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDataSource(url)
        mediaPlayer!!.prepare()
        mediaPlayer!!.start()

    }

    private fun playRadio(audioIndex: Int) {
        stopPlaying()
        Constants.iS_VIEW_READER_NAME = readerTv.isVisible
        Log.e("playAudio", "list$audioList")
        reader = audioList!![audioIndex]!!.name!!
        readerName.text = reader
        Constants.READER_NAME = reader
        url = audioList!![audioIndex]!!.url!!
        playMediaPlayer(url)
    }

    init {
        Log.e("network", "isOnline" + Constants.NETWORK_HANDLER.isOnline())
        onlineDataSource = QuranAudioOnlineDAtaSourceImp(ApiManager.getApis())
        offlineDataSource = QuranAudioOfflineDAtaSourceImp(MyDatabase.getInstance())
        quranAudioRepository = QuranAudioRepositoryImp(
            onlineDataSource,
            offlineDataSource,
            Constants.NETWORK_HANDLER
        )
    }

    private fun initViews() {
        playIcon = requireView().findViewById(R.id.stop_ic)
        pauseIcon = requireView().findViewById(R.id.pause_ic)
        previousIcon = requireView().findViewById(R.id.previous_ic)
        nextIcon = requireView().findViewById(R.id.next_ic)
        readerName = requireView().findViewById(R.id.reader_name_tv)
        readerTv = requireView().findViewById(R.id.reader_tv)
    }

    private fun stopPlaying() {
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
            pauseIcon.isVisible = false
            playIcon.isVisible = true
        }
    }

    private fun getAudioResponse() {
        lifecycleScope.launch {
            try {
                progressDialog.show()
                audioList = quranAudioRepository.getQuranAudio()
                Log.e("", "success$audioList")
                progressDialog.dismiss()

            } catch (ex: Exception) {
                progressDialog.dismiss()
                Log.e("", "exception" + ex.localizedMessage)
            }
        }
    }
}